#!/usr/bin/env bash

# ==============================================================================
# Script Name: generate_contributions.sh
# Description: Generates a realistic GitHub contribution history for 2025.
# Compatibility: macOS & Linux (bash 3.2+)
# ==============================================================================

set -euo pipefail

# --- Pre-flight Checks ---

# 1. Detect if git is initialized
if ! git rev-parse --is-inside-work-tree >/dev/null 2>&1; then
    echo "Error: Current directory is not a git repository. Please run 'git init' or navigate to a git repository." >&2
    exit 1
fi

# 2. Detect if a remote exists
if ! git remote | grep -q .; then
    echo "Warning: No remote repository detected. Commits will be generated locally, but push will be skipped/fail." >&2
fi

# 3. File setup & safety (Never overwrite existing files)
ACTIVITY_FILE="activity.md"
if [ ! -f "$ACTIVITY_FILE" ]; then
    echo "# Activity Log - 2025" > "$ACTIVITY_FILE"
    echo "" >> "$ACTIVITY_FILE"
    echo "This file records automated practice and project commits for the year 2025." >> "$ACTIVITY_FILE"
    echo "" >> "$ACTIVITY_FILE"
fi

# --- Helper Functions ---

# Check if a year is a leap year
is_leap_year() {
    local year=$1
    if (( year % 400 == 0 )); then
        return 0
    elif (( year % 100 == 0 )); then
        return 1
    elif (( year % 4 == 0 )); then
        return 0
    else
        return 1
    fi
}

# Get total days in a month for 2025
get_days_in_month() {
    local month=$1
    local year=2025
    case $month in
        1|3|5|7|8|10|12) echo 31 ;;
        4|6|9|11) echo 30 ;;
        2)
            if is_leap_year $year; then
                echo 29
            else
                echo 28
            fi
            ;;
    esac
}

# Random number between min and max (inclusive)
random_range() {
    local min=$1
    local max=$2
    echo $(( min + RANDOM % (max - min + 1) ))
}

# Array of realistic commit messages
COMMIT_MESSAGES=(
    "Fix bug"
    "Refactor code"
    "Improve README"
    "Update documentation"
    "Add DSA solution"
    "Optimize algorithm"
    "Cleanup"
    "Minor improvements"
    "UI tweaks"
    "Performance improvements"
    "Code formatting"
    "Initial implementation"
    "Solve LeetCode problem"
    "Binary Search"
    "Dynamic Programming"
    "Graph algorithm"
    "Tree traversal"
)

# Pick a random commit message from array
get_random_message() {
    local index=$(( RANDOM % ${#COMMIT_MESSAGES[@]} ))
    echo "${COMMIT_MESSAGES[$index]}"
}

# --- Main Logic ---

echo "Starting contribution history generation for 2025..."

TOTAL_COMMITS=0
ACTIVE_DAYS=0
TARGET_ACTIVE_DAYS=$(random_range 180 250)

# We will generate candidate days across the year and sample ~215 active days
# 2025-01-01 was a Wednesday (day of week: 3, 0=Sun, 6=Sat)
CURRENT_DOW=3

# Pre-determine active days distribution to target ~180-250 days with realistic gaps
declare -a DAY_ACTIVE
declare -a DAY_MONTH
declare -a DAY_NUM
declare -a DAY_IS_WEEKEND

day_idx=0
for month in {1..12}; do
    days_in_m=$(get_days_in_month $month)
    for (( d=1; d<=days_in_m; d++ )); do
        DAY_MONTH[$day_idx]=$month
        DAY_NUM[$day_idx]=$d
        
        # DOW: 0=Sun, 6=Sat
        if [ "$CURRENT_DOW" -eq 0 ] || [ "$CURRENT_DOW" -eq 6 ]; then
            DAY_IS_WEEKEND[$day_idx]=1
        else
            DAY_IS_WEEKEND[$day_idx]=0
        fi
        
        DAY_ACTIVE[$day_idx]=0
        
        day_idx=$((day_idx + 1))
        CURRENT_DOW=$(( (CURRENT_DOW + 1) % 7 ))
    done
done

TOTAL_YEAR_DAYS=$day_idx

# Mark inactive weeks randomly (2-4 inactive weeks throughout the year)
INACTIVE_WEEKS_COUNT=$(random_range 2 4)
declare -a INACTIVE_DAYS_MAP
for (( i=0; i<TOTAL_YEAR_DAYS; i++ )); do INACTIVE_DAYS_MAP[$i]=0; done

for (( w=0; w<INACTIVE_WEEKS_COUNT; w++ )); do
    start_day=$(random_range 10 $((TOTAL_YEAR_DAYS - 14)))
    for (( k=0; k<7; k++ )); do
        idx=$((start_day + k))
        if [ $idx -lt $TOTAL_YEAR_DAYS ]; then
            INACTIVE_DAYS_MAP[$idx]=1
        fi
    done
done

# Select active days targeting TARGET_ACTIVE_DAYS
selected_count=0
for (( i=0; i<TOTAL_YEAR_DAYS; i++ )); do
    if [ "${INACTIVE_DAYS_MAP[$i]}" -eq 1 ]; then
        continue
    fi
    
    is_wknd=${DAY_IS_WEEKEND[$i]}
    rand_val=$(random_range 1 100)
    
    # Threshold check
    if [ "$is_wknd" -eq 1 ] && [ "$rand_val" -le 72 ]; then
        DAY_ACTIVE[$i]=1
        selected_count=$((selected_count + 1))
    elif [ "$is_wknd" -eq 0 ] && [ "$rand_val" -le 56 ]; then
        DAY_ACTIVE[$i]=1
        selected_count=$((selected_count + 1))
    fi
done

echo "Target active days: $TARGET_ACTIVE_DAYS (Generated: $selected_count active days)"

# Iterate through each day of 2025 and commit
for (( i=0; i<TOTAL_YEAR_DAYS; i++ )); do
    if [ "${DAY_ACTIVE[$i]}" -eq 0 ]; then
        continue
    fi

    ACTIVE_DAYS=$((ACTIVE_DAYS + 1))
    month=${DAY_MONTH[$i]}
    day=${DAY_NUM[$i]}
    is_wknd=${DAY_IS_WEEKEND[$i]}

    # Weekends slightly more commits (1-5 vs 1-4)
    if [ "$is_wknd" -eq 1 ]; then
        daily_commits=$(random_range 1 5)
    else
        daily_commits=$(random_range 1 4)
    fi

    # Format month and day with leading zeros
    m_fmt=$(printf "%02d" "$month")
    d_fmt=$(printf "%02d" "$day")

    for (( c=1; c<=daily_commits; c++ )); do
        # Random commit time between 09:00 AM (09:00:00) and 11:30 PM (23:30:00)
        hour=$(random_range 9 23)
        if [ "$hour" -eq 23 ]; then
            minute=$(random_range 0 30)
        else
            minute=$(random_range 0 59)
        fi
        second=$(random_range 0 59)

        h_fmt=$(printf "%02d" "$hour")
        min_fmt=$(printf "%02d" "$minute")
        sec_fmt=$(printf "%02d" "$second")

        # ISO 8601 Date String
        COMMIT_DATE="2025-${m_fmt}-${d_fmt}T${h_fmt}:${min_fmt}:${sec_fmt}"

        # Append timestamp to activity.md before each commit
        msg=$(get_random_message)
        echo "- [${COMMIT_DATE}] ${msg}" >> "$ACTIVITY_FILE"

        # Stage changes
        git add "$ACTIVITY_FILE"

        # Skip empty commits
        if git diff --cached --quiet; then
            continue
        fi

        # Print progress while running
        echo "[$COMMIT_DATE] Commit #$((TOTAL_COMMITS + 1)): $msg"

        # Commit using specified author and committer dates
        GIT_AUTHOR_DATE="$COMMIT_DATE" GIT_COMMITTER_DATE="$COMMIT_DATE" \
            git commit -m "$msg" --quiet

        TOTAL_COMMITS=$((TOTAL_COMMITS + 1))
    done
done

echo ""
echo "=========================================="
echo "Generation complete!"
echo "Total Active Days: $ACTIVE_DAYS"
echo "Total Commits Created: $TOTAL_COMMITS"
echo "=========================================="
echo ""

# Ask for confirmation before pushing
if git remote | grep -q .; then
    read -p "Do you want to push these commits to the remote repository now? (y/N): " -n 1 -r
    echo ""
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        current_branch=$(git branch --show-current || echo "main")
        echo "Pushing to remote branch '$current_branch'..."
        git push origin "$current_branch"
        echo "Push successful!"
    else
        echo "Push skipped. You can push manually using 'git push'."
    fi
else
    echo "No remote repository configured. Skipping push prompt."
fi
