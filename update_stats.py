import os
import shutil

TOTAL_EASY = 944
TOTAL_MEDIUM = 2056
TOTAL_HARD = 934

# Thư mục gốc nơi các Extension LeetCode tự động đồng bộ file về
SYNC_FOLDER = "LeetCode_Submissions" 

def auto_sort_files():
    """
    Thuật toán tự động đọc file mới đồng bộ, phân tích độ khó 
    và di chuyển vào đúng thư mục Easy/Medium/Hard tương ứng.
    """
    if not os.path.exists(SYNC_FOLDER):
        return

    # Tạo các thư mục đích nếu chưa có
    for folder in ["Easy", "Medium", "Hard"]:
        if not os.path.exists(folder):
            os.makedirs(folder)

    # Quét qua từng file bài giải vừa được LeetCode sync về
    for filename in os.listdir(SYNC_FOLDER):
        if filename.endswith(".java"):
            file_path = os.path.join(SYNC_FOLDER, filename)
            
            # Đọc nội dung file để kiểm tra nhãn độ khó do Extension ghi lại
            try:
                with open(file_path, "r", encoding="utf-8") as f:
                    content = f.read().lower()
                
                # Phân tích từ khóa độ khó trong file comment
                if "easy" in content:
                    dest_folder = "Easy"
                elif "medium" in content:
                    dest_folder = "Medium"
                elif "hard" in content:
                    dest_folder = "Hard"
                else:
                    continue # Bỏ qua nếu không xác định được độ khó

                # Di chuyển file sang thư mục phân loại tương ứng
                shutil.move(file_path, os.path.join(dest_folder, filename))
                print(f"🤖 [Bot] Đã phân loại file {filename} vào thư mục {dest_folder}")
            except Exception as e:
                print(f"Lỗi khi đọc file {filename}: {e}")

def count_files(folder_name):
    if not os.path.exists(folder_name):
        return 0
    all_files = os.listdir(folder_name)
    return len([f for f in all_files if f.endswith('.java')])

try:
    # Bước 1: Kích hoạt bot tự động dọn dẹp và phân loại file trước
    auto_sort_files()

    # Bước 2: Đếm số lượng file sau khi đã được phân loại chuẩn chỉnh
    solved_easy = count_files("Easy")
    solved_medium = count_files("Medium")
    solved_hard = count_files("Hard")
    solved_all = solved_easy + solved_medium + solved_hard
    total_all = TOTAL_EASY + TOTAL_MEDIUM + TOTAL_HARD

    # Bước 3: Tính toán phần trăm
    pct_easy = f"{(solved_easy / TOTAL_EASY) * 100:.1f}"
    pct_medium = f"{(solved_medium / TOTAL_MEDIUM) * 100:.1f}"
    pct_hard = f"{(solved_hard / TOTAL_HARD) * 100:.1f}"

    # Bước 4: Tạo giao diện cấu trúc README.md hoàn mỹ với GEPS chuẩn kích thước
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

    with open("README.md", "w", encoding="utf-8") as f:
        f.write(readme_content)
    print("🤖 [Success] Hệ thống tự động phân loại và cập nhật tiến độ hoàn tất!")

except Exception as e:
    print(f"❌ [Error] Lỗi hệ thống: {e}")
