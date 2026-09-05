import os
import shutil

TARGET_DIRS = {
    "Easy": "Easy",
    "Medium": "Medium",
    "Hard": "Hard"
}

def get_difficulty_from_readme(readme_path):
    try:
        with open(readme_path, 'r', encoding='utf-8') as f:
            content = f.read()
            if "<h3>Easy</h3>" in content:
                return "Easy"
            elif "<h3>Medium</h3>" in content:
                return "Medium"
            elif "<h3>Hard</h3>" in content:
                return "Hard"
    except Exception as e:
        print(f"❌ Không thể đọc file {readme_path}: {e}")
    return None

def clean_and_organize():
    print("🚀 Bot đang tiến hành quét và dọn dẹp thư mục gốc...")
    has_changed = False
    
    # Tạo các folder Easy, Medium, Hard nếu chưa có
    for folder in TARGET_DIRS.values():
        if not os.path.exists(folder):
            os.makedirs(folder)

    for item in os.listdir('.'):
        # Bỏ qua các folder đích và các file ẩn (.git, .github)
        if os.path.isdir(item) and item not in TARGET_DIRS.values() and not item.startswith('.'):
            readme_path = os.path.join(item, "README.md")
            if os.path.exists(readme_path):
                difficulty = get_difficulty_from_readme(readme_path)
                if difficulty:
                    dest_dir = TARGET_DIRS[difficulty]
                    dest_path = os.path.join(dest_dir, item)
                    if os.path.exists(dest_path):
                        print(f"⚠️ Thư mục '{item}' đã có trong '{dest_dir}'. Bỏ qua.")
                        continue
                    try:
                        shutil.move(item, dest_path)
                        print(f"✅ Đã dời thành công: {item} ──> {dest_dir}/")
                        has_changed = True
                    except Exception as e:
                        print(f"❌ Lỗi khi di chuyển {item}: {e}")
    return has_changed

if __name__ == "__main__":
    changed = clean_and_organize()
    if not changed:
        exit(1)
