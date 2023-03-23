package com.senac.config.exceptions

class ErrorConnectionDatabaseException(message: String) : Exception(message) {
    constructor() : this("Error in connection database")
}