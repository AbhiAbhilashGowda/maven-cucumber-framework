package com.diatoz.automation.util;

import org.apache.commons.lang3.StringUtils;

import io.mail7.sdk.api.EmailApi;
import io.mail7.sdk.models.responsemodels.InboxResponse;
import io.mail7.sdk.util.AsyncHandler;
import io.mail7.sdk.util.ErrorResponse;
import io.mail7.sdk.util.Mail7SDK;

public class Mail7utitility {
	static String otp = null;

	public String getOTPfromMail(String email) {

		Mail7SDK.Initialize sdk = new Mail7SDK.Initialize();
		sdk.setApiKey("805426c4-1edb-443f-8a46-c104e8d3a3d2");
		sdk.setApiSecret("16372dd0-383c-419a-b140-aed8abf6f1f1");
		EmailApi Mail7EmailAPI = new EmailApi();
		System.out.println(email);

		Mail7EmailAPI.getEmails(email.replace("@mail7.io", ""), "", new AsyncHandler<InboxResponse>() {
			@Override
			public void onSuccess(InboxResponse response) {
				System.out.println(response.getData().toString());
				String temp = "<td style=\"font-weight:700;font-size:25px\"><span style=\"width:25%;background:#ff5733;padding:10px 25px;border-radius:1px;letter-spacing:5px;box-shadow:0px 0px 5px #00000040;color:#fff\">";
				int index = response.getData().toString().indexOf(temp);
				otp = response.getData().toString().substring(index + 185, index + 191);
				System.out.println("OTP is :" + otp);
			}

			@Override
			public void onFailure(ErrorResponse error) {
				System.out.println(error.getMessage());
			}
		});

		if (!StringUtils.isEmpty(otp)) {
			System.out.println(otp);

		}
		return otp;
	}

}
