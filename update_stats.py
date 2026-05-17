import os

# 1. Định nghĩa hằng số tổng số bài trên LeetCode tính đến thời điểm hiện tại
TOTAL_EASY = 944
TOTAL_MEDIUM = 2056
TOTAL_HARD = 934

def count_files(folder_name):
    """
    Thuật toán kiểm tra và đếm các file .java trong thư mục cục bộ
    """
    # Bắt lỗi nếu thư mục chưa được tạo trên Git
    if not os.path.exists(folder_name):
        return 0
    
    # Lấy danh sách tất cả các file trong thư mục
    all_files = os.listdir(folder_name)
    
    # Lọc và chỉ đếm các file có đuôi mở rộng là .java
    java_files = [f for f in all_files if f.endswith('.java')]
    
    return len(java_files)

try:
    # 2. Thực hiện đếm số lượng bài giải thực tế trong các thư mục local
    # (Hãy đảm bảo bạn đặt tên thư mục trên GitHub viết hoa chữ cái đầu y chang thế này)
    solved_easy = count_files("Easy")
    solved_medium = count_files("Medium")
    solved_hard = count_files("Hard")
    solved_all = solved_easy + solved_medium + solved_hard
    total_all = TOTAL_EASY + TOTAL_MEDIUM + TOTAL_HARD

    # 3. Tính toán phần trăm và định dạng chính xác 1 chữ số thập phân
    pct_easy = f"{(solved_easy / TOTAL_EASY) * 100:.1f}"
    pct_medium = f"{(solved_medium / TOTAL_MEDIUM) * 100:.1f}"
    pct_hard = f"{(solved_hard / TOTAL_HARD) * 100:.1f}"

    # 4. Thuật toán tạo chuỗi văn bản Markdown hoàn chỉnh cho README.md
    # Sử dụng đúng tham số ?width=400 và cấu hình màu ép buộc chuẩn LeetCode
    readme_content = f"""# 🏆 Hành trình chinh phục 4000 bài LeetCode

Chào mừng đến với không gian lưu trữ lời giải thuật toán của tôi! Hệ thống tự động đồng bộ từ LeetCode sang GitHub.

## 📊 Thống kê tiến độ LeetCode

<p align="center">
  <img src="https://img.shields.io/badge/LeetCode-{solved_all}_/_{total_all}_Solved-FFA116?style=for-the-badge&logo=leetcode&logoColor=white" alt="LeetCode Total" />
</p>

### 📈 Chi tiết các mức độ:

* **🟢 Easy:** `{solved_easy} / {TOTAL_EASY}`
  <br>
  <img src="https://geps.dev/progress/{pct_easy}?width=400&dangerColor=22c55e&warningColor=22c55e&successColor=22c55e" alt="Easy Progress" />

* **🟡 Medium:** `{solved_medium} / {TOTAL_MEDIUM}`
  <br>
  <img src="https://geps.dev/progress/{pct_medium}?width=400&dangerColor=eab308&warningColor=eab308&successColor=eab308" alt="Medium Progress" />

* **🔴 Hard:** `{solved_hard} / {TOTAL_HARD}`
  <br>
  <img src="https://geps.dev/progress/{pct_hard}?width=400&dangerColor=ef4444&warningColor=ef4444&successColor=ef4444" alt="Hard Progress" />

---
_Bảng tiến độ hiển thị chi tiết số bài giải thực tế trên hệ thống và được cập nhật tự động mỗi khi có bài mới được đẩy lên._
"""

    # Ghi đè toàn bộ nội dung mới vào file README.md
    with open("README.md", "w", encoding="utf-8") as f:
        f.write(readme_content)
    print("🤖 [Success] Đã tính toán lại tiến độ và cập nhật file README.md thành công!")

except Exception as e:
    print(f"❌ [Error] Hệ thống gặp lỗi khi xử lý hệ tống file: {e}")
