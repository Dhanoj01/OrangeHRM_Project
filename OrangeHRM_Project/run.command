#!/bin/bash
eval "$(/opt/homebrew/bin/brew shellenv zsh)"
cd "$(dirname "$0")" 
echo "Starting OrangeHRM Automation Tests..."
mvn clean test
echo ""
echo "Automation execution completed!"
read -p "Press Enter to close this window..."
