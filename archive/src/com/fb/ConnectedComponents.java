package com.fb;

import com.google.common.collect.ImmutableList;
import lombok.*;

import java.util.*;

public class ConnectedComponents {
    public static void main(String[] args) {
        ConnectedComponents obj = new ConnectedComponents();

        List<Contact> contacts = ImmutableList.<Contact>builder()
                .add(new Contact().builder().name("gyUser").emails(Arrays.asList("user@gmail.com", "user@yahoo.com")).build())
                .add(new Contact().builder().name("mUser").emails(Arrays.asList("user@microsoft.com")).build())
                .add(new Contact().builder().name("mhUser").emails(Arrays.asList("user@microsoft.com", "user@hotmail.com")).build())
                .add(new Contact().builder().name("gyUser2").emails(Arrays.asList("user2@gmail.com", "user2@yahoo.com")).build())
                .add(new Contact().builder().name("abc").emails(Arrays.asList("abc@gmail.com")).build())
                .add(new Contact().builder().name("xyz").emails(Arrays.asList("xyz@gmail.com")).build())
                .add(new Contact().builder().name("wxyz").emails(Arrays.asList("xyz@hotmail.com", "xyz@gmail.com")).build())
                .add(new Contact().builder().name("hUser").emails(Arrays.asList("user@hotmail.com")).build())
                .build();

        List<Set<Contact>> deduped = obj.dedup(contacts);
        deduped.forEach(cluster -> {
            System.out.println(cluster);
        });
    }

    public List<Set<Contact>> dedup(List<Contact> contacts) {
        List<Set<Contact>> result = new ArrayList<>();
        if (contacts == null || contacts.isEmpty()) {
            return result;
        }

        /* Build lookup. */
        Map<String, List<Contact>> lookup = new HashMap<>();
        contacts.forEach(contact -> {
            contact.emails.forEach(email -> {
                lookup.putIfAbsent(email, new ArrayList<>());
                lookup.get(email).add(contact);
            });
        });

        final Set<String> visited = new HashSet<>();
        for (String email : lookup.keySet()) {
            final Set<Contact> cluster = new HashSet<>();
            traverse(email, lookup, visited, cluster);
            if (!cluster.isEmpty()) {
                result.add(cluster);
            }
        }
        return result;
    }

    private void traverse(String email, Map<String, List<Contact>> lookup, Set<String> visited, Set<Contact> cluster) {
        if (visited.contains(email)) {
            return;
        }

        visited.add(email);
        lookup.get(email).forEach(contact -> {
            contact.emails.forEach(cEmail -> {
                traverse(cEmail, lookup, visited, cluster);
            });
            cluster.add(contact);
        });
    }

    @Data
    @EqualsAndHashCode
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Contact {
        private String name;
        private List<String> emails;

        @Override
        public String toString() {
            return name;
        }
    }
}
