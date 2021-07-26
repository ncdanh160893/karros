pwd; ls -ltrh;
java -version;
curl https://downloads.apache.org//jmeter/binaries/apache-jmeter-5.4.1.tgz -o apache-jmeter-5.4.1.tgz;
tar -xvzf apache-jmeter-5.4.1.tgz;
mv apache-jmeter-5.4.1 apache-jmeter;
mkdir -p -m a=rwx report;
cp -R src/test/resource/performance apache-jmeter/bin; 
cd apache-jmeter/bin;
sh jmeter.sh -n -t performance/geocode.jmx -l geocode.jtl -Jhost=ath-be-ktvn-eks.athena-nonprod.com;
sh jmeter.sh -g geocode.jtl -f -e -o geocode;
cd ../../report;
rm -rf geocode;
mv ../apache-jmeter/bin/geocode .;
tar -cvzf geocode.tgz geocode;
mv ../apache-jmeter/bin/geocode.jtl .;

#cd ..
#rm apache-jmeter-5.4.1.tgz;
#rm -rf apache-jmeter;