#!/usr/bin/env python3
"""Add Persian explanatory comments to Kotlin/Kotlin-Gradle source files.

This helper exists because TarikhYar follows a project rule: source files should be
self-explanatory when opened by a developer. The script is intentionally idempotent;
files that already carry the marker are not rewritten a second time.
"""

from __future__ import annotations

from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
MARKER = "// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است."
EXCLUDED_PARTS = {".git", ".gradle", "build", ".idea"}


def should_process(path: Path) -> bool:
    """Return True only for human-maintained Kotlin/KTS files in the repository."""
    if path.suffix not in {".kt", ".kts"}:
        return False
    return not any(part in EXCLUDED_PARTS for part in path.parts)


def describe(code: str) -> str:
    """Create a short Persian explanation appropriate for the current source line."""
    stripped = code.strip()

    if stripped.startswith("package "):
        return "این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند."
    if stripped.startswith("import "):
        imported = stripped.removeprefix("import ").strip()
        return f"این import وابستگی «{imported}» را برای استفاده در این فایل وارد می‌کند."
    if stripped.startswith("@Composable"):
        return "این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است."
    if stripped.startswith("@"):
        return "این Annotation رفتار یا متادیتای declaration بعدی را برای کامپایلر مشخص می‌کند."
    if stripped.startswith("enum class "):
        return "این enum مجموعه محدود و مشخصی از حالت‌های قابل استفاده را تعریف می‌کند."
    if stripped.startswith("data class "):
        return "این data class یک مدل داده سبک برای نگهداری مقادیر مرتبط تعریف می‌کند."
    if stripped.startswith("class ") or stripped.startswith("private class "):
        return "این خط یک کلاس و مسئولیت مشخص آن را در معماری برنامه تعریف می‌کند."
    if stripped.startswith("object ") or stripped.startswith("private object "):
        return "این object یک نمونه Singleton برای سرویس یا داده مشترک برنامه ایجاد می‌کند."
    if " fun " in f" {stripped} " or stripped.startswith("fun "):
        return "این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند."
    if stripped.startswith("override fun "):
        return "این تابع رفتار تعریف‌شده در کلاس والد یا Interface را بازنویسی می‌کند."
    if stripped.startswith("val ") or stripped.startswith("private val "):
        return "این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند."
    if stripped.startswith("var ") or stripped.startswith("private var "):
        return "این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود."
    if stripped.startswith("if ") or stripped.startswith("if("):
        return "این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود."
    if stripped.startswith("else if"):
        return "این شاخه شرط جایگزین را زمانی بررسی می‌کند که شرط قبلی برقرار نبوده است."
    if stripped.startswith("else"):
        return "این شاخه زمانی اجرا می‌شود که شرط‌های قبلی برقرار نباشند."
    if stripped.startswith("when ") or stripped.startswith("when("):
        return "این when بر اساس مقدار ورودی یکی از مسیرهای مشخص را انتخاب می‌کند."
    if stripped.startswith("for ") or stripped.startswith("for("):
        return "این حلقه مجموعه‌ای از مقادیر را پیمایش و دستورهای داخل خود را تکرار می‌کند."
    if stripped.startswith("while ") or stripped.startswith("while("):
        return "این حلقه تا زمانی که شرط برقرار باشد اجرای دستورات داخل خود را تکرار می‌کند."
    if stripped.startswith("return"):
        return "این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد."
    if stripped.startswith("try"):
        return "این بلوک عملیاتی را اجرا می‌کند که ممکن است Exception ایجاد کند."
    if stripped.startswith("catch") or stripped.startswith("} catch"):
        return "این بخش خطای احتمالی بلوک try را کنترل می‌کند تا برنامه Crash نکند."
    if stripped.startswith("finally") or stripped.startswith("} finally"):
        return "این بخش در هر حالت برای آزادسازی منبع یا پاک‌سازی نهایی اجرا می‌شود."
    if stripped.startswith("Row("):
        return "این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد."
    if stripped.startswith("Column("):
        return "این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد."
    if stripped.startswith("Box("):
        return "این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند."
    if stripped.startswith("LazyColumn("):
        return "این LazyColumn فهرست عمودی و قابل اسکرول را به شکل بهینه نمایش می‌دهد."
    if stripped.startswith("Text("):
        return "این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد."
    if stripped.startswith("Icon("):
        return "این Icon نشانه گرافیکی مرتبط با عملکرد این قسمت را نمایش می‌دهد."
    if stripped.startswith("Surface(") or stripped.startswith("Card("):
        return "این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود."
    if "onClick" in stripped:
        return "این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند."
    if stripped.startswith("modifier") or ".padding(" in stripped or ".fillMax" in stripped:
        return "این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند."
    if stripped.startswith("plugins"):
        return "این بلوک Pluginهای لازم برای ساخت ماژول را فعال می‌کند."
    if stripped.startswith("android"):
        return "این بلوک تنظیمات Android مانند SDK، نسخه و Build Typeها را تعریف می‌کند."
    if stripped.startswith("dependencies"):
        return "این بلوک کتابخانه‌های مورد نیاز پروژه را به سیستم Build معرفی می‌کند."
    if stripped.startswith("implementation(") or stripped.startswith("debugImplementation(") or stripped.startswith("testImplementation("):
        return "این خط یک وابستگی را برای نوع Build مربوطه به پروژه اضافه می‌کند."
    if stripped in {"{", "}", "},", ")", "),"}:
        return "این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند."

    return "این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند."


def comment_file(path: Path) -> bool:
    """Insert one explanatory comment before each non-empty Kotlin/KTS code line."""
    text = path.read_text(encoding="utf-8")
    if MARKER in text:
        return False

    lines = text.splitlines()
    output: list[str] = [MARKER]
    in_triple_string = False

    for line in lines:
        stripped = line.strip()

        # Raw triple-quoted strings must remain byte-for-byte unchanged inside the literal.
        if in_triple_string:
            output.append(line)
            if line.count('"""') % 2 == 1:
                in_triple_string = False
            continue

        if not stripped:
            output.append(line)
            continue

        # Existing source comments are preserved and are not themselves explained by another comment.
        if stripped.startswith("//") or stripped.startswith("/*") or stripped.startswith("*") or stripped.startswith("*/"):
            output.append(line)
            continue

        indent = line[: len(line) - len(line.lstrip())]
        output.append(f"{indent}// راهنما: {describe(line)}")
        output.append(line)

        if line.count('"""') % 2 == 1:
            in_triple_string = True

    path.write_text("\n".join(output) + "\n", encoding="utf-8")
    return True


def main() -> None:
    """Process every Kotlin/KTS source file and print the changed paths for CI logs."""
    changed: list[Path] = []
    for path in sorted(ROOT.rglob("*")):
        if path.is_file() and should_process(path) and comment_file(path):
            changed.append(path)

    print(f"Commented {len(changed)} source files.")
    for path in changed:
        print(path.relative_to(ROOT))


if __name__ == "__main__":
    main()
