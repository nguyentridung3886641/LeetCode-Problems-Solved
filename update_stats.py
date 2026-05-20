import json
import math

# 1. Đọc dữ liệu từ file json có sẵn của bạn
with open('stats.json', 'r') as f:
    data = json.load(f)

# Giả định cấu trúc stats.json của bạn chứa các trường này
easy_solved = data.get('easy', 62)
medium_solved = data.get('medium', 32)
hard_solved = data.get('hard', 0)
total_solved = easy_solved + medium_solved + hard_solved

# 2. Tính toán góc cho biểu đồ tròn (SVG Dasharray)
total_questions = 3935 # Tổng số bài trên LeetCode
percentage = (total_solved / total_questions) * 100
stroke_dash = f"{percentage} {100 - percentage}"

# 3. Tự vẽ biểu đồ tròn bằng mã SVG (Giao diện Darkmode xịn mịn)
svg_chart = f"""
<svg width="300" height="160" viewBox="0 0 300 160" xmlns="http://www.w3.org/2000/svg">
  <rect width="300" height="160" rx="15" fill="#1a1a1a" stroke="#2e2e2e" stroke-width="2"/>
  
  <circle r="45" cx="70" cy="80" fill="transparent" stroke="#333" stroke-width="10" />
  <circle r="45" cx="70" cy="80" fill="transparent" stroke="#ffa116" stroke-width="10" 
          stroke-dasharray="{stroke_dash}" stroke-dashoffset="25" stroke-linecap="round"/>
  
  <text x="70" y="82" font-family="Arial" font-size="16" font-weight="bold" fill="#ffffff" text-anchor="middle">{total_solved}</text>
  <text x="70" y="98" font-family="Arial" font-size="10" fill="#888888" text-anchor="middle">Solved</text>
  
  <text x="150" y="55" font-family="Arial" font-size="13" font-weight="bold" fill="#22c55e">🟢 Easy: {easy_solved}</text>
  <text x="150" y="85" font-family="Arial" font-size="13" font-weight="bold" fill="#eab308">🟡 Medium: {medium_solved}</text>
  <text x="150" y="115" font-family="Arial" font-size="13" font-weight="bold" fill="#ef4444">🔴 Hard: {hard_solved}</text>
</svg>
"""

# 4. Ghi đè cấu trúc hoàn chỉnh vào file README.md
readme_content = f"""# 🏆 Hành trình chinh phục 4000 bài LeetCode

Chào mừng đến với không gian lưu trữ lời giải thuật toán của tôi! Hệ thống tự động đồng bộ từ LeetCode sang GitHub.

---

## 📊 Thống kê tiến độ LeetCode

<p align="center">
  <a href="https://leetcode.com/u/nguyentridung3886641/">
    {svg_chart}
  </a>
</p>

---

### 🚀 Mục tiêu & Kế hoạch hành động:
* **Tần suất giữ liên tục:** Giải đều đặn 4 bài LeetCode mỗi ngày (Dành 5 - 6 tiếng/ngày).
* **Lộ trình:** Hoàn thành mục tiêu 4000 bài LeetCode trong vòng 3 năm tới để hướng tới vị trí Mid-level Engineer tại các tập đoàn BigTech ngay khi tốt nghiệp.

_Bảng tiến độ hiển thị chi tiết số bài giải thực tế trên hệ thống và được cập nhật tự động bằng sự kiện Push._
"""

with open('README.md', 'w', encoding='utf-8') as f:
    f.write(readme_content)

print("README updated successfully with native SVG Chart!")
