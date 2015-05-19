package com.example.ejfragmaestrodetalle;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements
		TituloFragment.onTituloSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (findViewById(R.id.fragment_container) != null) {
			if (savedInstanceState != null) {
				return;
			}
			TituloFragment fragment = new TituloFragment();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.fragment_container, fragment, null).commit();
		}
	}

	@Override
	public void onTituloSelected(int position) {
		
		ContenidoFragment contFragment = (ContenidoFragment) getSupportFragmentManager()
				.findFragmentById(R.id.contenidoFragment);
		
		if (contFragment != null) {
			contFragment.actualizarContenido(position);
		} else {
			contFragment = new ContenidoFragment();
			Bundle args = new Bundle();
			args.putInt(ContenidoFragment.POSICION, position);
			contFragment.setArguments(args);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, contFragment)
					.addToBackStack(null).commit();
		}
	}
}
