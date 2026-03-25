# 15. 3Sum

**Difficulty:** Medium  
**Topics:** Array, Two Pointers, Sorting  
**Companies:** (Premium)  

---

## Problem

Given an integer array `nums`, return all the triplets  
`[nums[i], nums[j], nums[k]]` such that:

- `i != j`
- `i != k`
- `j != k`
- `nums[i] + nums[j] + nums[k] == 0`

The solution set must **not contain duplicate triplets**.

---

## Example 1

**Input:**  
`nums = [-1,0,1,2,-1,-4]`

**Output:**  
`[[-1,-1,1],[-1,0,1]]`

**Explanation:**  
The distinct triplets are:
- (-1, -1, 2)
- (-1, 0, 1)

Order of the output and order of the triplets does not matter.

---

## Example 2

**Input:**  
`nums = [0,1,1]`

**Output:**  
`[]`

**Explanation:**  
The only possible triplet does not sum to 0.

---

## Example 3

**Input:**  
`nums = [0,0,0]`

**Output:**  
`[[0,0,0]]`

**Explanation:**  
The only possible triplet sums to 0.

---

## Constraints

- `3 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`