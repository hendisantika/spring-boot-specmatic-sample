package id.my.hendisantika.specmaticsample.filestorage

import java.io.File

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 02/07/25
 * Time: 07.51
 * To change this template use File | Settings | File Templates.
 */
class LocalFileSystem {
    companion object {
        fun saveImage(imageFileName: String?, bytes: ByteArray): String {
            val file = File(".images/$imageFileName")
            file.parentFile.mkdirs()
            file.writeBytes(bytes)
            return file.canonicalPath
        }
    }
}