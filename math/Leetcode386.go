func reportSpam(message []string, bannedWords []string) bool {
	// init map
    visited := make(map[string]bool)
	// add banned word to map
    for _, bannedWord := range bannedWords {
        visited[bannedWord] = true
    }
    var cnt int = 0
	// check message in map 
    for _, msg := range message {
		// check if msg in map 
        if visited[msg] {
            cnt++
        }
		// if cnt >= 2 return true
        if cnt >= 2 {
            return true
        }
    }
    return false
}