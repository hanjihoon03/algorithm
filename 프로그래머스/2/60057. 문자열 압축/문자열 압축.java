class Solution {
    public int solution(String s) {
         int minLength = s.length(); // 기본값: 압축이 안 되는 경우

        for (int len = 1; len <= s.length() / 2; len++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, len);
            int count = 1;

            for (int i = len; i < s.length(); i += len) {
                // 다음 블록 추출
                String current;
                if (i + len <= s.length()) {
                    current = s.substring(i, i + len);
                } else {
                    current = s.substring(i);
                }

                // 이전 블록과 같으면 count 증가
                if (prev.equals(current)) {
                    count++;
                } else {
                    // 다르면 지금까지 압축하고 초기화
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(prev);
                    prev = current;
                    count = 1;
                }
            }

            // 마지막 블록 처리
            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);

            minLength = Math.min(minLength, compressed.length());
        }

        return minLength;
    }
}