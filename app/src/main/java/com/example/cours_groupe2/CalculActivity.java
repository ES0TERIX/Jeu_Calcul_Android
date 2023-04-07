package com.example.cours_groupe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.cours_groupe2.DAO.ScoreBaseHelper;
import com.example.cours_groupe2.DAO.ScoreDao;
import com.example.cours_groupe2.model.entities.Score;

import java.util.Random;

public class CalculActivity extends AppCompatActivity {
    private TextView textViewCalcul;
    private String nom = "XXX";
    private TextView textViewProbleme;
    private Button boutonPlus;
    private Button boutonDivide;
    private Button boutonSubstract;
    private Button boutonMultiply;
    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;
    private Button bouton8;
    private Button bouton9;
    private Button bouton0;

    private Button boutonDelete;
    private Button boutonValider;

    private Integer premierTerme = 0;
    private Integer deuxiemeTerme = 0;
    private TypeOperationEnum typeOperation;
    private ScoreDao calculDao;
    private Integer reponse = 0;
    private Integer resultat = 0;

    private Integer score = 0;

    private Integer health = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        calculDao= new ScoreDao(new ScoreBaseHelper(this,"BDD",1));

        genererCalcul();

        textViewCalcul = findViewById(R.id.textViewCalcul);
        textViewProbleme = findViewById(R.id.textViewProbleme);

        boutonDivide = findViewById(R.id.button_divide);
        boutonDivide.setOnClickListener(view -> {
            ajouterSymbole(TypeOperationEnum.DIVIDE);
        });
        boutonPlus = findViewById(R.id.button_plus);
        boutonPlus.setOnClickListener(view -> {
            ajouterSymbole(TypeOperationEnum.ADD);
        });
        bouton0 = findViewById(R.id.buttonZero);
        bouton0.setOnClickListener(view -> {
            ajouterChiffre(0);
        });
        bouton1 = findViewById(R.id.button_1);
        bouton1.setOnClickListener(view -> {
            ajouterChiffre(1);
        });
        bouton2 = findViewById(R.id.button_2);
        bouton2.setOnClickListener(view -> {
            ajouterChiffre(2);
        });
        bouton3 = findViewById(R.id.button_3);
        bouton3.setOnClickListener(view -> {
            ajouterChiffre(3);
        });
        bouton4 = findViewById(R.id.button_4);
        bouton4.setOnClickListener(view -> {
            ajouterChiffre(4);
        });
        bouton5 = findViewById(R.id.button_5);
        bouton5.setOnClickListener(view -> {
            ajouterChiffre(5);
        });
        bouton6 = findViewById(R.id.button_6);
        bouton6.setOnClickListener(view -> {
            ajouterChiffre(6);
        });
        bouton7 = findViewById(R.id.button_7);
        bouton7.setOnClickListener(view -> {
            ajouterChiffre(7);
        });
        bouton8 = findViewById(R.id.button_8);
        bouton8.setOnClickListener(view -> {
            ajouterChiffre(8);
        });
        bouton9 = findViewById(R.id.button_9);
        bouton9.setOnClickListener(view -> {
            ajouterChiffre(9);
        });
        boutonSubstract = findViewById(R.id.button_substract);
        boutonSubstract.setOnClickListener(view -> {
            ajouterSymbole(TypeOperationEnum.SUBSTRACT);
        });
        boutonMultiply = findViewById(R.id.button_multiply);
        boutonMultiply.setOnClickListener(view -> {
            ajouterSymbole(TypeOperationEnum.MULTIPLY);
        });
        boutonDelete = findViewById(R.id.buttonDelete);
        boutonDelete.setOnClickListener(view -> {
            reponse = retirerDernier(reponse);
            majTextView();
        });
        boutonValider = findViewById(R.id.button_valider);
        boutonValider.setOnClickListener(view -> {
            verifier();
        });

    }
    public int retirerDernier(int number) {
        return number / 10;
    }

    private void ajouterSymbole(TypeOperationEnum typeOperation) {
        if (this.typeOperation != null) {
            Toast.makeText(this, getString(R.string.ERROR_ALREADY_HAVE_CALCUL_TYPE), Toast.LENGTH_LONG).show();
        } else {
            this.typeOperation = typeOperation;
            majTextView();
        }
    }
    private void genererCalcul(){
        textViewProbleme= findViewById(R.id.textViewProbleme);
        Random random = new Random();
        premierTerme = random.nextInt(999);
        premierTerme += 1;
        deuxiemeTerme = random.nextInt(999);
        deuxiemeTerme += 1;
        String symbole = "";
        int operateur = random.nextInt(4);
        switch (operateur){
            case 0:
                resultat = premierTerme+deuxiemeTerme;
                symbole = "+";
                break;
            case 1:
                resultat = premierTerme-deuxiemeTerme;
                symbole = "-";
                break;
            case 2:
                resultat = premierTerme*deuxiemeTerme;
                symbole = "*";
                break;
            case 3:
                deuxiemeTerme = 2;
                resultat = premierTerme/deuxiemeTerme;
                symbole = "/";
                break;
        }
        textViewProbleme.setText(premierTerme + symbole + deuxiemeTerme+ " = "+ resultat);
    }

    private void ajouterChiffre(Integer chiffre) {
        if (reponse <= 9999999) {
            reponse = 10 * reponse + chiffre;
            majTextView();
        } else {
            Toast.makeText(this, getString(R.string.ERROR_NUMBER_TOO_HIGH), Toast.LENGTH_LONG).show();
        }
    }

    private void majTextView() {
        textViewCalcul.setText("" + reponse);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemHealth = menu.findItem(R.id.item_health);
        MenuItem menuItemScore = menu.findItem(R.id.item_score);
        String titlehealth = getString(R.string.item_health) + " " + health;
        String titlescore = getString(R.string.item_score) + " " + score;

        menuItemHealth.setTitle(titlehealth);
        menuItemScore.setTitle(titlescore);
        return super.onPrepareOptionsMenu(menu);
    }

    public void verifier(){
        if (resultat.equals(reponse)) {
            score += 1;
            genererCalcul();
            invalidateOptionsMenu();
            reponse = 0;
            majTextView();
        }else{
            health -= 1;
            invalidateOptionsMenu();
            if (health.equals(0)){
                Score monScore = new Score();
                monScore.setScore(score);
                monScore.setNom(nom);
                Intent intent = new Intent(CalculActivity.this, NameActivity.class);
                intent.putExtra("SCORE", score);
                intent.putExtra("NOM", nom);
                startActivity(intent);
            }
        }
    }
}