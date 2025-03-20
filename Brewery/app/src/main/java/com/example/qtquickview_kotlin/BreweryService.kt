import com.example.qtquickview_kotlin.Brewery
import com.example.qtquickview_kotlin.BreweryApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BreweryService {
    private const val BASE_URL = "https://api.openbrewerydb.org/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(BreweryApi::class.java)

    suspend fun fetchNorthernMostBrewery(): Brewery? {
        return try {
            val breweries = api.getNorthernMostBrewery("Ireland")
            breweries.maxByOrNull { it.latitude?.toDoubleOrNull() ?: Double.MIN_VALUE }
        } catch (e: Exception) {
            null
        }
    }

    suspend fun fetchSouthernMostBrewery(): Brewery? {
        return try {
            val breweries = api.getSouthernMostBrewery("Ireland")
            breweries.minByOrNull { it.latitude?.toDoubleOrNull() ?: Double.MAX_VALUE }
        } catch (e: Exception) {
            null
        }
    }

    suspend fun fetchLongestNameBrewery(): Brewery? {
        return try {
            val breweries = api.getLongestNameBrewery("Ireland")
            breweries.maxByOrNull { it.name.length }
        } catch (e: Exception) {
            null
        }
    }
}
