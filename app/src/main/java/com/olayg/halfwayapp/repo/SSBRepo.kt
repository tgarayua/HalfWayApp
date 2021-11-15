package com.olayg.halfwayapp.repo

import android.util.Log
import com.olayg.halfwayapp.model.custom.Character
import com.olayg.halfwayapp.model.response.CharacterResponse
import com.olayg.halfwayapp.repo.remote.RetrofitInstance
import com.olayg.halfwayapp.util.logMe

object SSBRepo {

    private val smashBrosUnofficialService by lazy { RetrofitInstance.smashBrosUnofficialService }
    private val smashLoungeService by lazy { RetrofitInstance.smashLoungeService }

    suspend fun getAllCharacters() = try {
        smashLoungeService.getAllCharacters().map { characterResponse ->
            characterResponse.toString().logMe()
            Character.convertToCharacter(characterResponse, getImage(characterResponse))
        }
    } catch (ex: Exception) {
        "Error: $ex".logMe()
        emptyList()
    }

    private suspend fun getImage(character: CharacterResponse) = try {
        smashBrosUnofficialService.getAllCharacters(character.name).firstOrNull()?.image.also {
            "getImage $it".logMe()
        }
    } catch (ex: Exception) {
        null
    }
}