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

package com.liferay.osb.pulpo.lambda.handler;

/**
 * SendMessageToSlackRequest.
 *
 * @author Ruben Pulido
 */
public class SendMessageToSlackRequest {

	/**
	 * Gets the repository name.
	 *
	 * @return repository name
	 */
	public String getWebHookUrl() {
		return _webHookUrl;
	}

	/**
	 * Gets the message.
	 *
	 * @return message.
	 */
	public String getMessage() {
		return _message;
	}

	/**
	 * Sets the webHookUrl.
	 *
	 * @param webHookUrl a string with the webHookUrl
	 */
	public void setWebHookUrl(String webHookUrl) {
		_webHookUrl = webHookUrl;
	}

	/**
	 * Sets message.
	 *
	 * @param message a string with the message
	 */
	public void setMessage(String message) {
		_message = message;
	}

	/**
	 * Gets channel.
	 *
	 * @return the channel
	 */
  public String getChannel() {
		return _channel;
	}

  /**
   * Sets channel.
   *
   * @param channel the channel
   */
	public void setChannel(String channel) {
		_channel = channel;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(6);

		sb.append("SendMessageToSlackRequest{");
		sb.append("'_channel='");
		sb.append(_channel);
		sb.append("', _message='");
		sb.append(_message);
		sb.append(", _webHookUrl='");
		sb.append(_webHookUrl);
		sb.append("}");

		return sb.toString();
	}

	private String _channel;
	private String _message;
	private String _webHookUrl;

}