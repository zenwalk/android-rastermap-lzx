package com.asai.android.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class demoMain extends Activity {
	private Button btnDemo;
	private Spinner sprAnim;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		btnDemo = (Button) findViewById(R.id.btnDemo);
		sprAnim = (Spinner) findViewById(R.id.sprAnim);
		ArrayAdapter<?> animType = ArrayAdapter.createFromResource(this,
				R.array.anim_type, android.R.layout.simple_spinner_item);
		animType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sprAnim.setAdapter(animType);
		sprAnim.setSelection(0);
		btnDemo.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				startActivity(new Intent(demoMain.this, demoDetail.class));
				switch (sprAnim.getSelectedItemPosition()) {
				case 1:
					overridePendingTransition(R.anim.fade, R.anim.hold);
					break;
				case 2:
					overridePendingTransition(R.anim.alpha_rotate,
							R.anim.my_alpha_action);
					break;
				case 3:
					overridePendingTransition(R.anim.alpha_scale_rotate,
							R.anim.my_alpha_action);
					break;
				case 4:
					overridePendingTransition(
							R.anim.alpha_scale_translate_rotate,
							R.anim.my_alpha_action);
					break;
				case 5:
					overridePendingTransition(R.anim.alpha_scale_translate,
							R.anim.my_alpha_action);
					break;
				case 6:
					overridePendingTransition(R.anim.alpha_scale,
							R.anim.my_alpha_action);
					break;
				case 7:
					overridePendingTransition(R.anim.alpha_translate_rotate,
							R.anim.my_alpha_action);
					break;
				case 8:
					overridePendingTransition(R.anim.alpha_translate,
							R.anim.my_alpha_action);
					break;
				case 9:
					overridePendingTransition(R.anim.my_rotate_action,
							R.anim.my_alpha_action);
					break;
				case 10:
					overridePendingTransition(R.anim.my_scale_action,
							R.anim.my_alpha_action);
					break;
				case 11:
					overridePendingTransition(R.anim.my_translate_action,
							R.anim.my_alpha_action);
					break;
				case 12:
					overridePendingTransition(R.anim.myanimation_simple,
							R.anim.my_alpha_action);
					break;
				case 13:
					overridePendingTransition(R.anim.myown_design,
							R.anim.my_alpha_action);
					break;
				case 14:
					overridePendingTransition(R.anim.scale_rotate,
							R.anim.my_alpha_action);
					break;
				case 15:
					overridePendingTransition(R.anim.scale_translate_rotate,
							R.anim.my_alpha_action);
					break;
				case 16:
					overridePendingTransition(R.anim.scale_translate,
							R.anim.my_alpha_action);
					break;
				case 17:
					overridePendingTransition(R.anim.translate_rotate,
							R.anim.my_alpha_action);
					break;
				case 18:
					overridePendingTransition(R.anim.hyperspace_in,
							R.anim.hyperspace_out);
					break;
				case 19:
					overridePendingTransition(R.anim.shake,
							R.anim.my_alpha_action);
					break;
				case 20:
					overridePendingTransition(R.anim.push_left_in,
							R.anim.push_left_out);
					break;
				case 21:
					overridePendingTransition(R.anim.push_up_in,
							R.anim.push_up_out);
					break;
				case 22:
					overridePendingTransition(R.anim.slide_left,
							R.anim.slide_right);
					break;
				case 23:
					overridePendingTransition(R.anim.slide_top_to_bottom,
							R.anim.my_alpha_action);
					break;
				case 24:
					overridePendingTransition(R.anim.wave_scale,
							R.anim.my_alpha_action);
					break;
				}
			}
		});
	}
}