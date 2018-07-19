# AWS Lambda for sending a message to slack:

A parameter of type `SNSEvent` must be provided to the Lambda.

```
{
  [
    {
      sns: {
        messageAttributes: {},
        signingCertUrl: https://sns.us-east-1.amazonaws.com/SimpleNotificationService-eaea6120e66ea12e88dcd8bcbddca752.pem,messageId: 13107e7c-ae3a-594c-b852-2db658870bb0,
        message: {
          "AlarmName": "PULPO ES LOG WriteIOPS <= 100/hr",
          "AlarmDescription": "PULPO Elastic Search LOG WriteIOPS <= 100/hr",
          "AWSAccountId": "931050637112",
          "NewStateValue": "ALARM",
          "NewStateReason": "Threshold Crossed: 1 out of the last 1 datapoints [72.68 (19/07/18 20:26:00)] was less than or equal to the threshold (100.0) (minimum 1 datapoint for OK -> ALARM transition).",
          "StateChangeTime": "2018-07-19T20:28:45.502+0000",
          "Region": "US East (N. Virginia)",
          "OldStateValue": "OK",
          "Trigger": {
            "MetricName": "WriteIOPS",
            "Namespace": "AWS/ES",
            "StatisticType": "Statistic",
            "Statistic": "AVERAGE",
            "Unit": null,
            "Dimensions": [
              {
                "name": "ClientId",
                "value": "931050637112"
              },
              {
                "name": "DomainName",
                "value": "pulpo-elasticsearch-log"
              }
            ],
            "Period": 60,
            "EvaluationPeriods": 1,
            "ComparisonOperator": "LessThanOrEqualToThreshold",
            "Threshold": 100.0,
            "TreatMissingData": "- TreatMissingData:                    Breaching",
            "EvaluateLowSampleCountPercentile": ""
          }
        }
      },
        subject: ALARM: "PULPO ES LOG WriteIOPS <= 100/hr" in US East (N. Virginia),unsubscribeUrl: https://sns.us-east-1.amazonaws.com/?Action=Unsubscribe&SubscriptionArn=arn:aws:sns:us-east-1:931050637112:pulpo-prod-alerts-slack-topic:67cf8b78-5707-466f-895f-aef76648aee7,type: Notification,signatureVersion: 1,signature: hGDKZBkjKDuTWaBReuqHtMA9WD7wYEP+0+CJFB/3Us9y9UqwOT/OZcK9fCLZs7wOhHqQPa9bDYQVW/hUQQ+OadgSDzB2P/pWyeZd7UdY/XrMeaeX9LAFJQG/p4UnAhxqL1Ws0WjZzU6uW820o+Zx+i5ETnLPwYKlAkYVGi30+oTQYjlTIoOtqeCDx7Ls2hd/vR7lOWyCuYji34DyM7KNcKLWChT25gl6D6pEfk0n+df9vRwoREwQI4lQC2ygCnTaiw3EdlXpvPMiwOjQZx0Mkbls0q7Vlc5X6C+p3fhVY5gWbsPscsZb82EzfWGgA2usVZ/+c6iF8hyOSxZUsVXvEA==,timestamp: 2018-07-19T20:28:45.538Z,topicArn: arn:aws:sns:us-east-1:931050637112:pulpo-prod-alerts-slack-topic
      },
        eventVersion: 1.0,
        eventSource: aws:sns,
        eventSubscriptionArn: arn:aws:sns:us-east-1:931050637112:pulpo-prod-alerts-slack-topic:67cf8b78-5707-466f-895f-aef76648aee7
  }
  ]
}
```

The following environment variables are expected:

- *CHANNEL*: The name of the slack channel where the message should be sent. e.g: `#pulpo-dynatrace-prod

- *WEB_HOOK_URL*: The slack web hook url that should be used to send the message. e.g: `https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX`
