enum Membership {
	Simple,
	Standard,
	Premium
}

const membership = Membership.Standard
console.log(membership)
const membershipReverse = Membership[2]
console.log(membershipReverse)

enum SicialMedia {
	VK = 'VK',
	FACEBOOK = 'FACEBOOK',
	INSTAGRAM = 'INSTAGRAM'
}

const social = SicialMedia.INSTAGRAM
console.log(social)