package id.my.hendisantika.specmaticsample.model

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StringDeserializer
import java.io.IOException

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/07/25
 * Time: 05.56
 * To change this template use File | Settings | File Templates.
 */
class StrictStringDeserializer : StringDeserializer() {
    @Throws(IOException::class)
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): String? {
        val token = p.currentToken()
        if (token.isBoolean
            || token.isNumeric
            || !token.toString().equals("VALUE_STRING", ignoreCase = true)
        ) {
            ctxt.reportInputMismatch<Any>(String::class.java, "%s is not a `String` value!", token.toString())
            return null
        }
        return super.deserialize(p, ctxt)
    }
}