package com.example.animex.core

open class AppException: RuntimeException()

class EmptyFieldException: AppException()

class PasswordMismatchException : AppException()

class MinimumSizeOfPassword: AppException()

class AccountAlreadyExistsException : AppException()

class AuthException : AppException()

class StorageException: AppException()

class EmailNotMatchException: AppException()

class AccountNotExistException: AppException()
