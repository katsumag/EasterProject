import me.katsumag.easterproject.util.SVGPath
import org.junit.jupiter.api.Test

class SVGTest {

    @Test
    fun `test Jackson XML`() {
        println(SVGPath.get("cross_path.svg"))
    }

}