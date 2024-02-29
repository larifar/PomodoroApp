package br.com.fiap.pomodoroapp.util

import br.com.fiap.pomodoroapp.R

fun transformarTempo(tempo: Int): String{
    return if(tempo<60){
        String.format("00:%02d", tempo)
    } else{
        val min = tempo /60
        val seg = tempo % 60
        String.format("%02d:%02d", min, seg)
    }
}

fun mudarIcone(bol: Boolean): Int{
    if (bol){
        return R.drawable.baseline_pause_circle_24
    } else{
        return R.drawable.play_vector
    }
}