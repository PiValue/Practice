package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q811Domains {
    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null) return new ArrayList<>();

        final Map<String, Integer> counts = new HashMap<>();
        for (String cpdomain : cpdomains) {
            updateCounts(counts, cpdomain);
        }

        List<String> result = new ArrayList<>();
        for (String domain : counts.keySet()) {
            result.add(counts.get(domain) + " " + domain);
        }
        return result;
    }

    private void updateCounts(Map<String, Integer> counts, String domain) {
        String[] countDomain = domain.split(" ");

        Integer count = Integer.valueOf(countDomain[0].trim());
        String[] tokens = countDomain[1].trim().split("\\.");

        String temp = null;
        for (int i = tokens.length - 1; i >= 0; i--) {
            temp = (temp != null) ? tokens[i] + "." + temp : tokens[i];
            counts.putIfAbsent(temp, 0);
            counts.put(temp, counts.get(temp) + count);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Q811Domains().subdomainVisits(new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}
