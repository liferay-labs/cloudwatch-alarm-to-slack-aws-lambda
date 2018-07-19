/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.osb.pulpo.lambda.handler.sns;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.amazonaws.util.StringUtils;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.liferay.osb.pulpo.lambda.handler.SendMessageToSlackRequest;

import java.util.List;
import java.util.Map;

import javax.json.Json;

/**
 * Util class to convert a SNSEvent to a String.
 *
 * @author Ruben Pulido
 */
public class SnsAWSUtil {

	/**
	 * Converts a sns event to a string.
	 *
	 * @param snsEvent input snsEvent
	 * @param lambdaLogger lambda logger
	 * @return String containing the result
	 */
	public static String snsEventToString(
		SNSEvent snsEvent, LambdaLogger lambdaLogger) {

		_validateInputRequest(snsEvent);

		lambdaLogger.log("SNSEvent: " + snsEvent.toString());

		List<SNSEvent.SNSRecord> records = snsEvent.getRecords();

		SNSEvent.SNSRecord snsRecord = records.get(0);

		SNSEvent.SNS sns = snsRecord.getSNS();

		return sns.getSubject();
	}

	private static void _validateInputRequest(SNSEvent snsEvent) {

		if (snsEvent == null) {
			throw new IllegalArgumentException(
				"snsEvent must not be null");
		}
	}

}