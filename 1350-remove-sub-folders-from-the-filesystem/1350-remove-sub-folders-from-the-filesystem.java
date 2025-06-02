class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder); // Sort folders lexicographically
        List<String> result = new ArrayList<>();
        
        String prev = ""; // last added parent folder
        for (String f : folder) {
            // Only add if current folder is not a subfolder of the previous one
            if (prev.isEmpty() || !f.startsWith(prev + "/")) {
                result.add(f);
                prev = f;
            }
        }
        
        return result;
    }
}