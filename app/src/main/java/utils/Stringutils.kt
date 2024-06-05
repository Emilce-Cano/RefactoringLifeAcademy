package utils

object StringUtils {

    // Función de extension para validar el correo electrónico
    fun String.isValidEmail(): Boolean {
        val emailRegex = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
        return emailRegex.matches(this)
    }

    // Función de extension para validar la contraseña
    fun String.isValidPassword(): Boolean {
        // Reglas de validación de contraseña
        // (Faltarian o se modificarian segun lo que responda Backend respecto a la consulta de caracteristicas de las contraseñas):
        // - Mínimo 8 caracteres
        // - Al menos una letra mayúscula
        // - Al menos una letra minúscula
        // - Al menos un número
        // - Al menos un carácter especial (@$!%*+#=.?&)
        val passwordRegex =
            Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*+#=.?&]{8,}\$")
        return passwordRegex.matches(this)
    }
}