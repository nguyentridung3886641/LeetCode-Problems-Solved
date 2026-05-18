bool isSubsequence(char* s, char* t) {
    int i = 0; // Con trỏ cho chuỗi s
    int j = 0; // Con trỏ cho chuỗi t

    // Chạy cho đến khi một trong hai chuỗi kết thúc
    while (s[i] != '\0' && t[j] != '\0') {
        // Nếu ký tự khớp, ta tiến con trỏ i lên để tìm ký tự tiếp theo của s
        if (s[i] == t[j]) {
            i++;
        }
        // Luôn tiến con trỏ j lên để quét qua chuỗi t
        j++;
    }

    // Nếu con trỏ i đã chạy đến cuối chuỗi s, 
    // nghĩa là toàn bộ ký tự của s đã được tìm thấy theo đúng thứ tự.
    return s[i] == '\0';
}