currentBatch=1
runningXml="DBSAndroid"
while [ $currentBatch -le 6 ]
do
        processid = `pgrep -f "sudo mvn test -DsuiteXmlFile=$runningXml.xml"`
 if [ $processid -ge 0 ]
 then
         echo "$processid"
         sleep 10m
  else
          echo "$processid"
          echo "$currentBatch"
          cd /home/ubuntu/DBS_Automation/ExecutionTestData/$currentBatch
          sudo cp TestData.xlsx /home/ubuntu/DBS_Automation/TestData
          cd ../..
          if [ $currentBatch -ge 5 ]
          then
                  sudo mvn test -DsuiteXmlFile=DBSIOS.xml
                  sleep 10m
                  currentBatch=$(( currentBatch+1 ))
                  runningXml="DBSIOS"
          else
                  sudo mvn test -DsuiteXmlFile=DBSAndroid.xml
                  sleep 10m
                  currentBatch=$(( currentBatch+1 ))
                  runningXml="DBSAndroid"
          fi
 fi
  done
