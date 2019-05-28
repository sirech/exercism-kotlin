fun transcribeToRna(dna: String) = dna.map(::transcribe).joinToString(separator = "")

private fun transcribe(nucleotide: Char) = when (nucleotide) {
    'G' -> 'C'
    'C' -> 'G'
    'T' -> 'A'
    'A' -> 'U'
    else -> throw IllegalArgumentException("Not a nucleotide")
}
