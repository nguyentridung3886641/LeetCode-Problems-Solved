import os
import shutil

# ==============================================================================
# 1. CẤU HÌNH HẰNG SỐ HỆ THỐNG
# ==============================================================================
# Tổng số bài trên hệ thống LeetCode toàn cầu tính đến thời điểm hiện tại
TOTAL_EASY = 944
TOTAL_MEDIUM = 2056
TOTAL_HARD = 934

# Danh sách các thư mục hệ thống bắt buộc phải bỏ qua, không quét phân loại
IGNORE_FOLDERS = ['.git', '.github', 'Easy', 'Medium', 'Hard', 'stats.json']


# ==============================================================================
# 2. THUẬT TOÁN TỰ ĐỘNG PHÂN LOẠI (AUTO-CLASSIFY)
# ==============================================================================
def auto_classify_leethub_submissions():
    """
    Quét tất cả các thư mục bài toán do LeetHub tạo ra ở thư mục gốc,
    đọc độ khó từ file README.md nội bộ và tự động di chuyển vào Easy/Medium/Hard.
    """
    print("🤖 [Bot] Bắt đầu quét thư mục gốc để phân loại bài tập...")
    
    # Đảm bảo 3 thư mục chứa cốt lõi luôn tồn tại trên hệ thống file
    for folder in ["Easy", "Medium", "Hard"]:
        if not os.path.exists(folder):
            os.makedirs(folder)
            
    # Duyệt qua toàn bộ các thực thể ở thư mục gốc (Root)
    for item in os.listdir('.'):
        # Điều kiện: Phải là thư mục bài tập và không nằm trong danh sách loại trừ
        if os.path.isdir(item) and item not in IGNORE_FOLDERS:
            readme_path = os.path.join(item, "README.md")
            
            # Kiểm tra xem thư mục này có thực sự chứa file mô tả README.md của LeetHub không
            if os.path.exists(readme_path):
                try:
                    with open(readme_path, "r", encoding="utf-8") as f:
                        content = f.read()
                    
                    # Chuyển toàn bộ nội dung về chữ thường để bắt chính xác từ khóa độ khó
                    content_lower = content.lower()
                    
                    if "easy" in content_lower:
                        dest_folder = "Easy"
                    elif "medium" in content_lower:
                        dest_folder = "Medium"
                    elif "hard" in content_lower:
                        dest_folder = "Hard"
                    else:
                        print(f"⚠️ [Warning] Không tìm thấy nhãn độ khó trong [{item}]/README.md. Giữ nguyên.")
                        continue
                    
                    # Di chuyển nguyên cả thư mục bài tập vào ngăn độ khó tương ứng
                    shutil.move(item, os.path.join(dest_folder, item))
                    print(f"🟢 [Success] Đã đưa bài [{item}] vào thư mục -> {dest_folder}/")
                    
                except Exception as e:
                    print(f"❌ Lỗi khi xử lý phân loại thư mục {item}: {e}")


# ==============================================================================
# 3. THUẬT TOÁN ĐẾM SỐ LƯỢNG BÀI ĐÃ GIẢI (LOCAL COUNTING)
# ==============================================================================
def count_solved_problems(folder_name):
    """
    Đếm số lượng thư mục con (mỗi thư mục con đại diện cho 1 bài toán)
    đã được phân loại thành công bên trong Easy/Medium/Hard.
    """
    if not os.path.exists(folder_name):
        return 0
    
    # Chỉ đếm các thực thể là thư mục con bên trong folder đích
    subfolders = [f for f in os.listdir(folder_name) if os.path.isdir(os.path.join(folder_name, f))]
    return len(subfolders)


# ==============================================================================
# 4. LUỒNG ĐIỀU KHIỂN CHÍNH (MAIN PROCESS)
# ==============================================================================
if __name__ == "__main__":
    try:
        # Bước 1: Kích hoạt dọn dẹp và gom bài tập tự động từ thư mục gốc
        auto_classify_leethub_submissions()

        # Bước 2: Đếm số lượng bài thực tế sau khi phân loại
        solved_easy = count_solved_problems("Easy")
        solved_medium = count_solved_problems("Medium")
        solved_hard = count_solved_problems("Hard")
        
        solved_all = solved_easy + solved_medium + solved_hard
        total_all = TOTAL_EASY + TOTAL_MEDIUM + TOTAL_HARD

        # Bước 3: Tính toán tỷ lệ phần trăm (Định dạng chuẩn 1 chữ số thập phân)
        pct_easy = f"{(solved_easy / TOTAL_EASY) * 100:.1f}"
        pct_medium = f"{(solved_medium / TOTAL_MEDIUM) * 100:.1f}"
        pct_hard = f"{(solved_hard / TOTAL_HARD) * 100:.1f}"

        # Bước 4: Tạo cấu trúc nội dung file README.md mới với thanh GEPS chuẩn kích thước
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
_Bảng tiến độ hiển thị chi tiết số bài giải thực tế trên hệ thống và được cập nhật tự động bằng sự kiện Push._
"""

        # Bước 5: Ghi đè toàn bộ nội dung đã dựng vào file README.md
        with open("README.md", "w", encoding="utf-8") as f:
            f.write(readme_content)
        print("🤖 [Success] Toàn bộ hệ thống Dashboard đã được cập nhật mượt mà!")

    except Exception as e:
        print(f"❌ [Error] Hệ thống gặp trục trặc nghiêm trọng: {e}")
