cd /home/ubuntu/DBS_Automation/ExecutionTestData/$1
sudo cp TestData.xlsx /home/ubuntu/DBS_Automation/TestData
cd ../..
sudo mvn test -DsuiteXmlFile=$2.xml
