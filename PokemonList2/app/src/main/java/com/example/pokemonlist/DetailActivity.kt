import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonlist.Pokemon
import com.example.pokemonlist.R

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_POKEMON = "extra_pokemon"
    }

    private lateinit var imgPhoto: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imgPhoto = findViewById(R.id.img_item_photo)
        tvName = findViewById(R.id.tv_item_name)
        tvDescription = findViewById(R.id.tv_item_description)

        val pokemon = intent.getParcelableExtra<Pokemon>(EXTRA_POKEMON)

        if (pokemon != null) {
            imgPhoto.setImageResource(pokemon.photo)
            tvName.text = pokemon.name
            tvDescription.text = pokemon.description
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
