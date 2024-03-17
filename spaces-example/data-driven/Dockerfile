FROM gigaspaces/smart-cache-enterprise:16.5.0-m10
ADD target/empty-space-0.1.jar /opt/gigaspaces/bin/pu.jar

ENTRYPOINT ["/opt/entrypoint.sh"]
CMD ["host", "run-agent", "--auto"]
