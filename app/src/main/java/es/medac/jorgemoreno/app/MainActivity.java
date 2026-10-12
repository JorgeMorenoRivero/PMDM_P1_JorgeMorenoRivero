package es.medac.jorgemoreno.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txtEntrenoHoy = findViewById(R.id.txtEntrenoHoy);
        txtEntrenoHoy.setText(getString(R.string.entreno_hoy, getString(R.string.nombre_entreno)));

        Button btnEmpezar = findViewById(R.id.btnEmpezar);
        btnEmpezar.setOnClickListener(v -> startActivity(new Intent(this, RegistroActivity.class)));
    }
}