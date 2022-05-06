package com.sks.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A website domain "discuss.leetcode.com" consists of various subdomains. At the top level,
 * we have "com", at the next level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com".
 * When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
 * A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2"
 * where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.
 * Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input.
 * You may return the answer in any order.
 */
public class SubdomainVisitCount {

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> out = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) return out;
        Map<String, Integer> subDomainCountMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] countDomain = cpdomain.split(" ");
            int count = Integer.valueOf(countDomain[0]);
            List<String> subDomains = getSubDomains(countDomain[1]);
            System.out.println("subDomains = " + subDomains);
            for (String sd : subDomains) {
                subDomainCountMap.put(sd, subDomainCountMap.getOrDefault(sd, 0) + count);
            }
        }
        System.out.println("subDomainCountMap = " + subDomainCountMap);
        for (Map.Entry<String, Integer> entry : subDomainCountMap.entrySet())
            out.add(entry.getValue() + " " + entry.getKey());
        return out;
    }

    private static List<String> getSubDomains(String domain) {
        String[] subDomains = domain.split("\\.");
        List<String> allDomains = new ArrayList<>();
        String dom = "";
        for (int i = subDomains.length - 1; i >= 0; i--) {
            dom = dom == "" ? subDomains[i] : subDomains[i] + "." + dom;
            allDomains.add(dom);
        }
        return allDomains;
    }

    public static void main(String[] args) {
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        List<String> out = subdomainVisits(cpdomains);
        System.out.println("SubDomain visits count = " + out);
    }
}
