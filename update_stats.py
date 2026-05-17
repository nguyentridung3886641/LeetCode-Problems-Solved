import os
import shutil

# Định nghĩa hằng số tổng số bài trên LeetCode toàn cầu
TOTAL_EASY = 944
TOTAL_MEDIUM = 2056
TOTAL_HARD = 934

# Danh sách các thư mục hệ thống cần bỏ qua, không quét phân loại
IGNORE_FOLDERS = ['.git', '.github', 'Easy', 'Medium', 'Hard']

def auto_classify_leethub_submissions():
    """
    Thuật toán quét các thư mục bài toán do LeetHub tạo ra ở thư mục gốc,
    đọc độ khó từ file README.md nội bộ và phân loại về đúng vị trí.
    """
    # Đảm bảo các thư mục cốt lõi luôn tồn tại
    for folder in ["Easy", "Medium", "Hard"]:
        if not os.path.exists(folder):
            os.makedirs(folder)
            
    # Lấy danh sách các thực thể ở thư mục gốc
    for item in os.listdir('.'):
        # Chỉ xử lý nếu nó là thư mục bài tập và không nằm trong danh sách loại trừ
        if os.path.isdir(item) and item not in IGNORE_FOLDERS:
            readme_path = os.path.join(item, "README.md")
            
            # Kiểm tra xem thư mục bài tập này có chứa file README.md do LeetHub sinh ra không
            if os.path.exists(readme_path):
                try:
                    with open(readme_path, "r", encoding="utf-8") as f:
                        content = f.read().lower()
                    
                    # Xác định nhãn độ khó được LeetHub ghi trong README
                    if "easy" in content:
                        dest_folder = "Easy"
                    elif "medium" in content:
                        dest_folder = "Medium"
                    elif "hard" in content:
                        dest_folder = "Hard"
                    else:
                        continue # Không tìm thấy nhãn độ khó thì bỏ qua
                    
                    # Di chuyển toàn bộ thư mục bài tập vào thư mục độ khó tương ứng
                    shutil.move(item, os.path.join(dest_folder, item))
                    print(f"🤖 [Bot] Đã phân loại thành công bài [{item}] vào ngăn {dest_folder}")
                    
                except Exception as e:
                    print(f"Lỗi khi phân loại thư mục {item}: {e}")

def count_solved_problems(folder_name):
    """
    Đếm số lượng thư mục bài toán đã được phân loại bên trong Easy/Medium/Hard
    """
    if not os.path.exists(folder_name):
        return 0
    # Mỗi thư mục con đại diện cho 1 bài toán đã giải
    subfolders = [f for f in os.listdir(folder_name) if os.path.isdir(os.path.join(folder_name, f))]
    return len(subfolders)

try:
    # Bước 1: Kích hoạt hệ thống tự động quét và thu dọn phân loại file
    auto_classify_leethub_submissions()

    # Bước 2: Đếm số lượng bài thực tế sau phân loại
    solved_easy = count_solved_problems("Easy")
    solved_medium = count_solved_problems("Medium")
    solved_hard = count_solved_problems("Hard")
    
    solved_all = solved_easy + solved_medium + solved_hard
    total_all = TOTAL_EASY + TOTAL_MEDIUM + TOTAL_HARD

    # Bước 3: Tính toán phần trăm chính xác (Format 1 chữ số thập phân)
    pct_easy = f"{(solved_easy / TOTAL_EASY) * 100:.1f}"
    pct_medium = f"{(solved_medium / TOTAL_MEDIUM) * 100:.1f}"
    pct_hard = f"{(solved_hard / TOTAL_HARD) * 100:.1f}"

    # Bước 4: Tạo cấu trúc file README.md mới với thanh GEPS tùy biến màu sắc cố định
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
    print("🤖 [Success] Đã đồng bộ cấu trúc LeetHub và cập nhật Dashboard thành công!")

except Exception as e:
    print(f"❌ [Error] Hệ thống trục trặc: {e}")
