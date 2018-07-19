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

package com.liferay.osb.pulpo.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.liferay.osb.pulpo.lambda.handler.SendMessageToSlackRequest;
import com.liferay.osb.pulpo.lambda.handler.slack.SlackAWSUtil;
import com.liferay.osb.pulpo.lambda.handler.sns.SnsAWSUtil;

/**
 * Lambda which receives a SNSEvent containing a Cloudwatch Alert and sends
 * a message to a Slack channel
 *
 * @author Ruben Pulido
 */
public class LambdaHandler implements RequestHandler<SNSEvent, String> {

	@Override
	public String handleRequest(
		SNSEvent snsEvent, Context context) {

		LambdaLogger logger = context.getLogger();

		String message = SnsAWSUtil.snsEventToString(snsEvent, logger);

		SendMessageToSlackRequest sendMessageToSlackRequest =
			_getSendMessageToSlackRequest(message);

		logger.log(
			"Sending message to slack: " + sendMessageToSlackRequest + "\n");

		return SlackAWSUtil.sendMessageToSlack(
			sendMessageToSlackRequest, logger);
	}

	private SendMessageToSlackRequest _getSendMessageToSlackRequest(
		String message) {

		SendMessageToSlackRequest sendMessageToSlackRequest =
			new SendMessageToSlackRequest();

		sendMessageToSlackRequest.setMessage(message);

		String webHookUrl = System.getenv("WEB_HOOK_URL");

		sendMessageToSlackRequest.setWebHookUrl(webHookUrl);

		String channel = System.getenv("CHANNEL");

		sendMessageToSlackRequest.setChannel(channel);

		return sendMessageToSlackRequest;
	}

}