package com.paulbutcher.mrsdoyle

import scala.util.Random

object Utterances {
  
  def invitation = pickRandom(
    "Will you have a cup of tea?", 
    "Will you have a cup of tea father?", 
    "We were just about to have a cup of tea, will you join us?", 
    "Join us in a cup of tea?", 
    "Tea perchance?", 
    "Could I interest you in a brew?", 
    "Hot beverage?", 
    "Tea for two, two for tea... will you join us?",
    "What would you say to a cup father?",
    "Fancy a cup o' the hot stuff?")
    
  def goodIdea = pickRandom(
    "Fantastic idea, I'll see who else wants one and get back to you in a couple of minutes", 
    "I was just about to suggest the same thing. I'll see who else wants one", 
    "Coming right up... in a couple of minutes", 
    "You do have the best ideas, I'll see who else will join us")
    
  def whatDidYouSay = pickRandom(
    "I don't understand what you're saying...",
    "If it's not about tea, I'm afraid I'm not really interested...",
    "Pardon?",
    "Beg pardon?",
    "Hm?",
    "Umm.....",
    "Pancakes.",
    "I fail to see the relevance...",
    "Is there something I can do for you?",
    "Are you sure you're speaking English?",
    "Now really, whatever does that mean?",
    "I'm afraid I'm just not familiar with this new slang you young people use.",
    "You always say that!")

  def pickRandom(options: String*) = options(Random.nextInt(options.length)) 
}
