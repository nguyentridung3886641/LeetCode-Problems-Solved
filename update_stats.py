import requests
import json

# 1. Cấu hình thông tin tài khoản LeetCode
USERNAME = "nguyentridung3886641"

# Client-ID công khai của Imgur ứng dụng cộng đồng (Dùng để upload ảnh miễn phí)
IMGUR_CLIENT_ID = "546c25a59c58ad7" 

url = "https://leetcode.com/graphql"
query = """
query userProblemsSolved($username: String!) {
    allQuestionsCount { difficulty count }
    matchedUser(username: $username) {
        submitStats {
            acSubmissionNum { difficulty count submissions }
        }
    }
}
"""

variables = {"username": USERNAME}
headers = {"Content-Type": "application/json"}

try:
    response = requests.post(url, json={"query": query, "variables": variables}, headers=headers)
    data = response.json()
    
    stats = data['data']['matchedUser']['submitStats']['acSubmissionNum']
    total_counts = data['data']['allQuestionsCount']
    
    solved_easy = next(x['count'] for x in stats if x['difficulty'] == 'Easy')
    solved_medium = next(x['count'] for x in stats if x['difficulty'] == 'Medium')
    solved_hard = next(x['count'] for x in stats if x['difficulty'] == 'Hard')
    solved_all = next(x['count'] for x in stats if x['difficulty'] == 'All')
    
    total_easy = next(x['count'] for x in total_counts if x['difficulty'] == 'Easy')
    total_medium = next(x['count'] for x in total_counts if x['difficulty'] == 'Medium')
    total_hard = next(x['count'] for x in total_counts if x['difficulty'] == 'Hard')
    total_all = next(x['count'] for x in total_counts if x['difficulty'] == 'All')
    
    CIRCUMFERENCE = 314.16
    dash_easy = (solved_easy / total_all) * CIRCUMFERENCE
    dash_medium = (solved_medium / total_all) * CIRCUMFERENCE
    dash_hard = (solved_hard / total_all) * CIRCUMFERENCE

    # Thiết kế chuỗi SVG đồ thị tròn chuẩn giao diện LeetCode
    svg_content = f"""<svg width="350" height="170" viewBox="0 0 350 170" fill="none" xmlns="http://www.w3.org/2000/svg">
        <style>
            .text {{ font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif; fill: white; }}
            .bold {{ font-weight: bold; font-size: 22px; fill: #ffffff; }}
            .label {{ font-size: 14px; fill: #8a8a8a; }}
            .easy {{ fill: #22c55e; font-weight: bold; }}
            .medium {{ fill: #eab308; font-weight: bold; }}
            .hard {{ fill: #ef4444; font-weight: bold; }}
        </style>
        <rect width="350" height="170" rx="10" fill="#1e1e1e"/>
        <circle cx="90" cy="85" r="50" stroke="#333333" stroke-width="10" />
        <circle cx="90" cy="85" r="50" stroke="#22c55e" stroke-width="10" 
                stroke-dasharray="{dash_easy} {CIRCUMFERENCE - dash_easy}" transform="rotate(-90 90 85)"/>
        <text x="90" y="80" text-anchor="middle" class="text bold">{solved_all}</text>
        <text x="90" y="100" text-anchor="middle" class="text label">/{total_all} Solved</text>
        <text x="180" y="50" class="text label">Easy</text>
        <text x="250" y="50" class="text easy">{solved_easy}</text>
        <text x="290" y="50" class="text label">/{total_easy}</text>
        <text x="180" y="90" class="text label">Medium</text>
        <text x="250" y="90" class="text medium">{solved_medium}</text>
        <text x="290" y="90" class="text label">/{total_medium}</text>
        <text x="180" y="130" class="text label">Hard</text>
        <text x="250" y="130" class="text hard">{solved_hard}</text>
        <text x="290" y="130" class="text label">/{total_hard}</text>
    </svg>"""
    
    # 2. Đẩy thẳng ảnh SVG lên Imgur thông qua API độc lập
    imgur_url = "https://api.imgur.com/3/image"
    imgur_headers = {{"Authorization": f"Client-ID {IMGUR_CLIENT_ID}"}}
    imgur_payload = {{"image": svg_content, "type": "svg"}}
    
    imgur_response = requests.post(imgur_url, headers=imgur_headers, data=imgur_payload)
    img_link = imgur_response.json()['data']['link']
    print(f"Upload Imgur thành công! Link ảnh: {img_link}")
    
    # 3. Sử dụng Python ghi đè trực tiếp liên kết ảnh mới vào file README.md
    readme_text = f"""# 🏆 Hành trình chinh phục 4000 bài LeetCode

Chào mừng đến với không gian lưu trữ lời giải thuật toán của tôi! Hệ thống tự động đồng bộ từ LeetCode sang GitHub.

## 📊 Thống kê tiến độ LeetCode

<p align="center">
  <img src="{img_link}" alt="LeetCode Stats" />
</p>

_Biểu đồ tiến độ phía trên được vẽ tự động bằng Python script kết hợp API lưu trữ tĩnh._
"""
    with open("README.md", "w", encoding="utf-8") as f:
        f.write(readme_text)
        
except Exception as e:
    print(f"Hệ thống gặp lỗi: {e}")
