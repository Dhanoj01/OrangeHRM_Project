#!/bin/bash
echo "Starting OrangeHRM Automation Tests..."
cd "$(dirname "$0")"
mvn clean test
echo "Automation execution completed!"
