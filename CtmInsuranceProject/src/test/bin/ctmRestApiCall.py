import requests
import json
from pyspark.sql import SparkSession
from pyspark.sql.functions import DataFrame
from pyspark.sql.types import StructType, StringType, StructField, array

def sendStream(spark, apiName) :
  dirPath="/users/manmanok/documents/test_data/insuranceDb/"
  df = spark.read.csv(dirPath + "/" + apiName + ".csv", sep=",", header=True).toJSON()
  for i in range(0, df.count()):
    jsonBody = df.collect()[i]
    print(jsonBody)
    executeRestApi('post', 'http://localhost:9091/api/v1/' + apiName, '', jsonBody)




def executeRestApi(verb, url, headers, body):
  #
  headers = {
      'content-type': "application/json"
  }
  res = None
  # Make API request, get response object back, create dataframe from above schema.
  try:
    if verb == "get":
      res = requests.get(url, data=body, headers=headers)
    else:
      res = requests.post(url, data=body, headers=headers)
  except Exception as e:
    return e
  if res != None and res.status_code == 200:
    return json.loads(res.text)
  return None



spark = SparkSession.builder.appName("insuranceAnalysis").getOrCreate()

sendStream(spark, "userdetails")
sendStream(spark, "addressdetails")
sendStream(spark, "userpolicies")
sendStream(spark, "refpolicytypes")
sendStream(spark, "policysubtypes")
sendStream(spark, "policypayments")


