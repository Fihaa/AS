package com.alatheer.anwaralfyaha.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alatheer.anwaralfyaha.Activities.Arcmenu;
import com.alatheer.anwaralfyaha.CustomToast;
import com.alatheer.anwaralfyaha.R;
import com.alatheer.anwaralfyaha.Utils;
import com.alatheer.anwaralfyaha.dataProccess.Connector;
import com.alatheer.anwaralfyaha.dataProccess.DataEncap;
import com.alatheer.anwaralfyaha.dataProccess.JsonParser;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login_Fragment extends Fragment implements OnClickListener {
	private static View view;
	final static String api = "http://wefakhail.org/fihaa/api/students";
	JsonParser parser = new JsonParser();
	private static EditText emailid;
	private static Button loginButton;
	private static TextView forgotPassword, signUp;
	private static LinearLayout loginLayout;
	private static Animation shakeAnimation;
	private static FragmentManager fragmentManager;
	RadioButton student;

	public Login_Fragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.login_layout, container, false);
		initViews();
		setListeners();
		return view;
	}

	// Initiate Views
	private void initViews() {
		fragmentManager = getActivity().getSupportFragmentManager();

		emailid = (EditText) view.findViewById(R.id.login_emailid);

		loginButton = (Button) view.findViewById(R.id.loginBtn);
		//student= (RadioButton) view.findViewById(R.id.radiostu);

		loginLayout = (LinearLayout) view.findViewById(R.id.login_layout);

		// Load ShakeAnimation
		shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
				R.anim.shake);

		// Setting text selector over textviews

		}


	// Set Listeners
	private void setListeners() {
		loginButton.setOnClickListener(this);

		// Set check listener over checkbox for showing and hiding password

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.loginBtn:

		//checkValidation();
			Intent i =new Intent(getContext(), Arcmenu.class);
			startActivity(i);
			break;

		}

	}

	// Check Validation before login
	private void checkValidation() {
		Connector connector = new Connector();
		DataEncap d=new DataEncap();
		try {

			ArrayList<DataEncap> arrayList = parser.JsonProcesstable(connector.execute(api).get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		// Get email id and password
		String getEmailId = emailid.getText().toString();
		//String getPassword = password.getText().toString();

		// Check patter for email id
		Pattern p = Pattern.compile(Utils.regEx);

		Matcher m = p.matcher(getEmailId);

		// Check for both field is empty or not
		if (getEmailId.equals("") || getEmailId.length() == 0
				) {
			loginLayout.startAnimation(shakeAnimation);
			new CustomToast().Show_Toast(getActivity(), view,
					"Enter Your ID.");

		}
		// Check if email id is valid or not
		else if (!m.find())
			new CustomToast().Show_Toast(getActivity(), view,
					"Your Email Id is Invalid.");
		// Else do login and do your stuff
		else if(d.getId()== getEmailId ){
			Toast.makeText(getActivity(), "Do Login.", Toast.LENGTH_SHORT)
					.show();

	}else

		Toast.makeText(getActivity(), "Do nnnnnnnnnn Login.", Toast.LENGTH_SHORT)
					.show();
	}
}
