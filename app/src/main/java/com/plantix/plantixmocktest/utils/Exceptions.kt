package com.plantix.plantixmocktest.utils

import java.io.IOException

class ApiExceptions(message: String?, val code: Int?) : IOException(message)
