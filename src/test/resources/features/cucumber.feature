Feature: Post Functionality
  Scenario Outline: As a customer I want to create a new post
    Given I can create post
    And I send post to be created with post title <post_title>, content <post_content>
    Then I should be able to see my created post

    Examples:
    | post_id | post_title | post_content       |
    | 1       | Fawaz      | slfkqmfkql msfsq   |
    | 2       | Alaa       | lqs mqsfqk lmf     |
