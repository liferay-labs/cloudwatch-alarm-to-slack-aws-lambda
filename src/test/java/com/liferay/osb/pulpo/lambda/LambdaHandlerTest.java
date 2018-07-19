package com.liferay.osb.pulpo.lambda;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import org.junit.Assert;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruben Pulido
 */
public class LambdaHandlerTest {

  @Test
  public void handleRequestTest() {

    // Given
    SNSEvent snsEvent = _getSnsEvent();

    Context context = _getContext();

    LambdaHandler lambdaHandler = new LambdaHandler();

    // When
    String response = lambdaHandler.handleRequest(snsEvent, context);

    // Then
    Assert.assertEquals("ok", response);
  }

  private SNSEvent _getSnsEvent() {
    OffsetDateTime utcDateTime = OffsetDateTime.now(ZoneOffset.UTC);

    SNSEvent.SNS sns = new SNSEvent.SNS();

    sns.setSubject("Test Subject " + utcDateTime.toString());

    SNSEvent snsEvent = new SNSEvent();

    List<SNSEvent.SNSRecord> records = new ArrayList<>();

    SNSEvent.SNSRecord snsRecord = new SNSEvent.SNSRecord();

    snsRecord.setSns(sns);

    records.add(snsRecord);

    snsEvent.setRecords(records);

    return snsEvent;
  }

  private Context _getContext() {
    return new Context() {
      @Override
      public String getAwsRequestId() {
        return null;
      }

      @Override
      public String getLogGroupName() {
        return null;
      }

      @Override
      public String getLogStreamName() {
        return null;
      }

      @Override
      public String getFunctionName() {
        return null;
      }

      @Override
      public String getFunctionVersion() {
        return null;
      }

      @Override
      public String getInvokedFunctionArn() {
        return null;
      }

      @Override
      public CognitoIdentity getIdentity() {
        return null;
      }

      @Override
      public ClientContext getClientContext() {
        return null;
      }

      @Override
      public int getRemainingTimeInMillis() {
        return 0;
      }

      @Override
      public int getMemoryLimitInMB() {
        return 0;
      }

      @Override
      public LambdaLogger getLogger() {
        return System.out::println;
      }
    };
  }

}