package br.com.movieapp.framework.utils

import br.com.movieapp.BuildConfig

fun String?.toPostURL() = "${BuildConfig.BASE_URL_IMAGE}$this"
fun String?.toBackdropURL() = "${BuildConfig.BASE_URL_IMAGE}$this"