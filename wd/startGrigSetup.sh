#!/bin/bash

cd /Users/amirwaisman/WebdriverFramework/wd/src/drivers

echo  "Starting Grid server..."

java -jar selenium-server-standalone-3.0.1.jar -port 4444 -role hub > /dev/null 2>&1 &

echo  "Starting Chrome node..."

java -Dwebdriver.chrome.driver=chromedriver -jar selenium-server-standalone-3.0.1.jar -role webdriver -hub http://localhost:4444/grid/register -browser browserName=chrome,platform=MAC -port 5558 > /dev/null 2>&1 &

echo  "Starting Firefox node..."

java -Dwebdriver.gecko.driver=geckodriver -jar selenium-server-standalone-3.0.1.jar -role webdriver -hub http://localhost:4444/grid/register -browser browserName=firefox,platform=MAC -port 5559  > /dev/null 2>&1 &

echo "Done."