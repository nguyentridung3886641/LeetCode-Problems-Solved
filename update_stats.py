import requests
import json
import math

USERNAME = "nguyentridung3886641"

url = "https://leetcode.com/graphql"
query = """
query userProblemsSolved($username: String!) {
    allQuestionsCount { difficulty count }
    matchedUser(username: $username) {
        submitStats {
            acSubmissionNum { difficulty count }
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
        <circle cx="90" cy="85" r="50" stroke="#eab308" stroke-width="10" 
                stroke-dasharray="{dash_medium} {CIRCUMFERENCE - dash_medium}" transform="rotate({-90 + (dash_easy/CIRCUMFERENCE)*360} 90 85)"/>
        <circle cx="90" cy="85" r="50" stroke="#ef4444" stroke-width="10" 
                stroke-dasharray="{dash_hard} {CIRCUMFERENCE - dash_hard}" transform="rotate({-90 + ((dash_easy + dash_medium)/CIRCUMFERENCE)*360} 90 85)"/>
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
    
    # Ghi trực tiếp thành file ảnh local trong Repository
    with open("leetcode_stats.svg", "w", encoding="utf-8") as f:
        f.write(svg_content)
    print("Đã tạo file leetcode_stats.svg thành công tại local!")
        
except Exception as e:
    print(f"Lỗi: {e}")
