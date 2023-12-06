// Autogenerated from Pigeon (v14.0.0), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package com.loloof64.open_save_file_dialogs

import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

private fun wrapResult(result: Any?): List<Any?> {
  return listOf(result)
}

private fun wrapError(exception: Throwable): List<Any?> {
  if (exception is FlutterError) {
    return listOf(
      exception.code,
      exception.message,
      exception.details
    )
  } else {
    return listOf(
      exception.javaClass.simpleName,
      exception.toString(),
      "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
    )
  }
}

/**
 * Error class for passing custom error details to Flutter via a thrown PlatformException.
 * @property code The error code.
 * @property message The error message.
 * @property details The error details. Must be a datatype supported by the api codec.
 */
class FlutterError (
  val code: String,
  override val message: String? = null,
  val details: Any? = null
) : Throwable()

/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface OpenSaveFileDialogs {
  fun saveFileDialog(startingFileName: String?, callback: (Result<String?>) -> Unit)

  companion object {
    /** The codec used by OpenSaveFileDialogs. */
    val codec: MessageCodec<Any?> by lazy {
      StandardMessageCodec()
    }
    /** Sets up an instance of `OpenSaveFileDialogs` to handle messages through the `binaryMessenger`. */
    @Suppress("UNCHECKED_CAST")
    fun setUp(binaryMessenger: BinaryMessenger, api: OpenSaveFileDialogs?) {
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.open_save_file_dialogs.OpenSaveFileDialogs.saveFileDialog", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val startingFileNameArg = args[0] as String?
            api.saveFileDialog(startingFileNameArg) { result: Result<String?> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                val data = result.getOrNull()
                reply.reply(wrapResult(data))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}
